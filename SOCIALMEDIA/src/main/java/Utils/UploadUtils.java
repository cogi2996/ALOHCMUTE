package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtils {
	public static String processUpload(String fileName, HttpServletRequest req, String storeFolder, String storeFilename) throws IOException, ServletException {
		Part filePart = req.getPart(fileName);
		if(filePart == null || filePart.getSize() == 0) {
			return "";
		}
		if(storeFolder == null) {
			storeFolder = Constant.DIR;
		}
		if(storeFilename== null) {
			storeFilename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		}
		// nếu là null rồi thì lấy extension đó gửi lại cái file để chọn lại 
		else {
			storeFilename +="."+FilenameUtils.getExtension(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
		}
		Path uploadPath = Paths.get(storeFolder);
		// kiểm tra nếu file không tồn tại 
		if(!Files.exists(uploadPath))
		{	
			Files.createDirectories(uploadPath);
		}
		filePart.write(Paths.get(uploadPath.toString(),storeFilename).toString());
		return storeFilename;
	}
}
