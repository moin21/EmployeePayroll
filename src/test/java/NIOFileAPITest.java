import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {
	/**
	 * HOME: user's home directory PLAY_WITH_NIO
	 */
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "Directory";

	/**
	 * Test method to verify File Existence, File Deletion, Directory Creation and
	 * Empty File Creation
	 * 
	 * @throws IOException
	 */
	@Test
	public void givenPathChecked_ThenConfirmed() throws IOException {
		/**
		 * Path Creation: homePath
		 */
		Path homePath = Paths.get(HOME);
		/**
		 * Assertion that homePath exists
		 */
		Assert.assertTrue(Files.exists(homePath));
		/**
		 * Path Creation: playPath, p
		 * 
		 */
		Path p = Paths.get(HOME + "/playDelete.txt");
		/**
		 * Assertion if file p exists: It doesn't.
		 */
		Assert.assertFalse(Files.exists(p));
		/**
		 * Created empty file p
		 */
		Files.createFile(p);
		/**
		 * Asserting if file p exists: It does
		 */
		Assert.assertTrue(Files.exists(p));
		/**
		 * Deleted file p
		 */
		Files.delete(p);
		/**
		 * Asserting if file p exists: Already deleted
		 */
		Assert.assertFalse(Files.exists(p));
	}

	/**
	 * Test method to create and verify Directory
	 * 
	 * @throws IOException
	 */
	@Test
	public void createdDirectory_ThenChecked() throws IOException {
		/**
		 * Path Creation: playPath
		 */
		Path playPath = Paths.get("/home/Directory");
		/**
		 * Created Directory: playPath(home/Directory)
		 */
		Files.createDirectory(playPath);
		/**
		 * Asserting if created Directory exists.
		 */
		Assert.assertTrue(Files.exists(playPath));
	}
}
