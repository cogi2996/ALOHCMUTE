package firebase;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FireBaseService {

	FirebaseApp db;

	public FireBaseService() throws IOException {

		FileInputStream serviceAccount = new FileInputStream(
				"src/main/resources/strange-song-394808-firebase-adminsdk-i6wm1-237bb10752.json");

		FirebaseOptions options = FirebaseOptions.builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://strange-song-394808-default-rtdb.firebaseio.com")
				  .build();

				db = FirebaseApp.initializeApp(options);
	}

	public FirebaseApp getDb() {
		return db;
	}

	public static void main(String[] args) throws IOException {
		// Khởi tạo FireBaseService
		FireBaseService fireBaseService = new FireBaseService();

		// Lấy đối tượng FirebaseDatabase
		FirebaseApp db = fireBaseService.getDb();

		// Kiểm tra xem đối tượng FirebaseDatabase có null hay không
		if (db != null) {
			System.out.println("ket noi thanh cong");
		} else {
			System.out.println("ket noi that bai");
		}
	}
}
