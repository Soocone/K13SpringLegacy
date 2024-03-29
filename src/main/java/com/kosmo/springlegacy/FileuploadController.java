package com.kosmo.springlegacy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileuploadController {
	//파일 업로드를 위한 디렉토리의 물리적 경로 확인하기
	@RequestMapping("/fileUpload/uploadPath.do")
	//request, response 내장객체를 사용하기 위해 매개변수로 선언
	public void uploadPath(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		
		//request 내장객체를 통해 서버의 물리적 경로 얻어옴
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		//upload 디렉토리는 정적파일을 저장하기 위한 resources 하위에 생성한다.
		
		//response 내장객체를 통해 MIME타입을 설정한다.
		resp.setContentType("text/html; charset=utf-8");
		
		//View를 호출하지 않고 컨트롤러에서 즉시 출력한다.
		PrintWriter pw = resp.getWriter();
		
		pw.print("/upload 디렉토리의 물리적 경로: "+ path);
	}
	
	//파일 업로드 폼 매핑
	@RequestMapping("/fileUpload/uploadForm.do")
	public String uploadForm() {
		return "06FileUpload/uploadForm";
	}
	
	/*
	 UUID(Universally Unique Identifier)
	 	: 범용 고유 식별자. randomUUID()를 통해 문자열을 생성하면
	 	하이픈이 4개 포함된 32자의 랜덤하고 유니크한 문자열이 생성된다.
	 	JDK에서 기본 클래스로 제공된다.
	 */
	public static String getUuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println("생성된UUID-1:"+ uuid);
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된UUID-2:"+ uuid);
		return uuid;
	}
	
	
	/*
	 파일 업로드 처리
	 	: 파일 업로드는 Post 방식으로 전송해야 하므로 매핑시 method, value 두가지
	 	속성을 모두 기술해야 한다.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/fileUpload/uploadAction.do")
	//파일업로드를 위한 객체를 매개변수로 선언한다.
	public String uploadAction(Model model, MultipartHttpServletRequest req) {
		
		//물리적 경로 얻어오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		MultipartFile mfile = null;
		
		//파일 정보를 저장한 Map 컬렉션을 2개이상 저장하기 위한 용도의 List 컬렉션
		List<Object> resultList = new ArrayList<Object>();
		
		try {
			String title = req.getParameter("title");
			
			//업로드폼의 file속성의 필드를 가져온다.(여기서는 2개임)
			Iterator itr = req.getFileNames();
			
			//갯수만큼 반복
			while(itr.hasNext()) {
				//전송된 파일명을 읽어온다.
				mfile = req.getFile(itr.next().toString());
				
				//한글개짐방지 처리 후 전송된 파일명을 가져온다.
				String originalName = new String(mfile.getOriginalFilename().getBytes(), "UTF-8");
				
				//서버로 전송된 파일이 없다면 while문의 처음으로 돌아간다.
				if("".equals(originalName)) continue;
				
				//파일명에서 확장자를 따낸다.
				String ext = originalName.substring(originalName.lastIndexOf('.'));
				
				//UUID를 통해 생성된 문자열과 확장자를 결합해서 파일명을 완성한다.
				String saveFileName = getUuid() + ext;
				
				//물리적경로에 새롭게 생성된 파일명으로 파일 저장
				mfile.transferTo(new File(path + File.separator + saveFileName));
				
				//폼값과 파일명을 저장할 Map컬렉션 생성
				Map<String, String> fileMap = new HashMap<String, String>();
				
				//원본파일명, 저장된 파일명, 제목을 저장한다.
				fileMap.put("originalName", originalName);
				fileMap.put("saveFileName", saveFileName);
				fileMap.put("title", title);
				
				//하나의 파일정보를 저장한 Map을 List에 저장한다.(현재 파일 2개임)
				resultList.add(fileMap);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("resultList", resultList);
		return "06FileUpload/uploadAction";
	}
	
	
	//파일 목록보기
	@RequestMapping("/fileUpload/uploadList.do")
	public String uploadList(HttpServletRequest req, Model model) {
		//물리적 경로 얻어오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		//경로를 기반으로 파일객체 생성
		File file = new File(path);
		//파일의 목록을 배열 형태로 얻어옴
		File[] fileArray = file.listFiles();
		//View로 전달할 파일목록 저장을 위해 Map 컬렉션 생성
		Map<String, Integer> fileMap = new HashMap<String, Integer>();
		for(File f : fileArray) {
			//key와 value로 파일명과 파일용량을 저장한다.
			fileMap.put(f.getName(), (int)Math.ceil(f.length()/1024.0));
		}
		
		model.addAttribute("fileMap", fileMap);
		return "06FileUpload/uploadList";
	}
	
	
	//파일 다운로드 처리
	@RequestMapping("/fileUpload/download.do")
	public ModelAndView download(HttpServletRequest req, 
			HttpServletResponse resp) throws Exception{
		/*
		 파일리스트에서 다운로드 링크는 
		 download.do?fileName=${file.key }&oriFileName=임시파일명
		 와 같이 걸려있다.
		 */
		String fileName = req.getParameter("fileName");//저장된 파일명
		String oriFileName = req.getParameter("oriFileName");//원본파일명
		
		//물리적 경로
		String saveDirectory = 
				req.getSession().getServletContext().getRealPath("/resources/upload");
		
		//경로와 파일명을 통해 파일객체 생성
		File downloadFile = new File(saveDirectory+"/"+fileName);
		
		//해당 경로에 파일이 있는지 확인
		if(!downloadFile.canRead()) {
			throw new Exception("파일을 찾을 수 없습니다.");
		}
		
		//다운로드를 위한 View와 Model 처리
		ModelAndView mv = new ModelAndView();
		//다운로드 할 View 명
		mv.setViewName("fileDownloadView");
		//저장된 파일의 전체 경로명
		mv.addObject("downloadFile", downloadFile);
		//원본 파일명
		mv.addObject("oriFileName", oriFileName);
		
		return mv;
	}
}
