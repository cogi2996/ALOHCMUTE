package firebase;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.auth.UserRecord.UpdateRequest;

import Model.UserModel;

public class FireBaseService {

	private FirebaseApp firebase;
	private FirebaseAuth auth;

	public FireBaseService() {

		try {
			FileInputStream serviceAccount = new FileInputStream(this.getClass().getClassLoader()
					.getResource("strange-song-394808-firebase-adminsdk-i6wm1-237bb10752.json").getFile());

			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://strange-song-394808-default-rtdb.firebaseio.com").build();

			this.firebase = FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FirebaseAuth getAuth() {
		this.auth = FirebaseAuth.getInstance(this.firebase);
		return FirebaseAuth.getInstance(this.firebase);
	}

	public UserRecord createUserWithEmailAndPass(UserModel user) throws FirebaseAuthException {
//		System.out.println(this.auth);
		System.out.println("Da den buoc create account tren firebase");
		CreateRequest request = new CreateRequest().setEmail(user.getGmail()).setEmailVerified(true)
				.setPassword(user.getPassword()).setDisplayName(user.getFirstName());
		System.out.println("user duoc gui" + user);
		System.out.println("authen duoc gui" + auth);
		UserRecord userRecord = this.auth.createUser(request);
		// lấy thông tin đã đăng kí
		return userRecord;
	}

	public void updateInfoUser(UserModel user,String uid) throws FirebaseAuthException {
		String e164PhoneNumber = "+84" + user.getMobile().substring(1);
		UpdateRequest request = new UpdateRequest(uid)
			    .setEmail(user.getGmail())
			    .setPhoneNumber(e164PhoneNumber)
			    .setEmailVerified(true)
			    .setPassword(user.getPassword())
			    .setDisplayName(user.getLastName()+' '+user.getMidName()+' '+user.getFirstName())
			    .setPhotoUrl("https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/361329007_312693551181553_539974167945346689_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=efb6e6&_nc_eui2=AeHnLS1K7KiBCKN00W1acY-Rw3O1525OlrLDc7Xnbk6Wsq9BMGcv4eA9zcH2l2nbW7US3tiJQvNFrzOSMBUhsvID&_nc_ohc=PRaE8781SzsAX_s9jio&_nc_ht=scontent.fsgn2-11.fna&oh=00_AfAaUw0hklF94prUiv9woGFsLHIHoodTuB_JS5APn-FZFA&oe=657468C3g")
			    ;

			UserRecord userRecord = this.auth.updateUser(request);
			System.out.println("Successfully updated user: " + userRecord.getUid());
	}

	public static void main(String[] args) throws IOException, FirebaseAuthException {
		// Khởi tạo FireBaseService

		// Lấy đối tượng FirebaseDatabase
//		FireBaseService firebaseService = new FireBaseService();
//		FirebaseApp firebase = firebaseService.getFirebase();
//		FirebaseAuth auth = firebaseService.getAuth();

		// Kiểm tra xem đối tượng FirebaseDatabase có null hay không
		/*
		 * if (auth != null) { // System.out.println(auth); UserRecord userRecord =
		 * auth.getUser("V7osGsJ1VAdywvtvLEKInpgKjmv2"); // See the UserRecord reference
		 * doc for the contents of userRecord.
		 * System.out.println("Successfully fetched user data: " +
		 * userRecord.getEmail()); } else { System.out.println("ket noi that bai"); }
		 */
//		firebaseService.createUserWithEmailAndPass(null);
	}
}
