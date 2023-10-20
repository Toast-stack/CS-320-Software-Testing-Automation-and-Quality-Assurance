package contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	protected String contactID, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String LongContactID, LongFirstName, LongLastName,LongPhoneNumber,ShortPhoneNumber,LongAddress;
	
	/* Test templates for contacts
	 * Contact("32482482","Maisy","Gordon","6545324348","8098 Chestnut Lane");
	 * Contact ("39742066","Lillian","Rogers","4535754508","83 West Bowman Drive");
	 * Contact ("47649185","Aiden","Alexander","9112302485","62 Trout Avenue");
	 * 
	 */
	
	
	@BeforeEach
	void setUp() {
		contactID = "11111111";
		firstNameTest = "Jane";
		lastNameTest = "Doe";
		phoneNumberTest = "1234567891";
		addressTest = "83 West Bowman Drive";
		LongContactID = "12345678912";
		LongFirstName ="Bill William Billiam";
		LongLastName ="Werbenjägermanjensen";
		LongPhoneNumber ="123456789123";
		ShortPhoneNumber = "12345678";
		LongAddress = "8209 Primrose Ave, Wakefield, MA 01880";
		}
	
	@Test
	void newContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll("service",
			()-> assertNotNull(service.getContactList().get(0).getContactID()),
			()-> assertEquals("INITIAL",
					service.getContactList().get(0).getFirstName()),
			()-> assertEquals("INITIAL",
					service.getContactList().get(0).getLastName()),
			()-> assertEquals("1234567891",
					service.getContactList().get(0).getPhoneNumber()),
			()-> assertEquals("INITIAL",
					service.getContactList().get(0).getAddress()));
			service.newContact(firstNameTest);
	
		assertAll("service",
			()-> assertNotNull(service.getContactList().get(1).getContactID()),
			()-> assertEquals(firstNameTest,
				service.getContactList().get(1).getFirstName()),
			()-> assertEquals("INITIAL",
				service.getContactList().get(1).getLastName()),
			()-> assertEquals("1234567891",
				service.getContactList().get(1).getPhoneNumber()),
			()-> assertEquals("INITIAL",
				service.getContactList().get(1).getAddress()));
			service.newContact(firstNameTest, lastNameTest);
	
		assertAll("service",
			()-> assertNotNull(service.getContactList().get(2).getContactID()),
			()-> assertEquals(firstNameTest,
					service.getContactList().get(2).getFirstName()),
			()-> assertEquals(lastNameTest,
					service.getContactList().get(2).getLastName()),
			()-> assertEquals("1234567891",
					service.getContactList().get(2).getPhoneNumber()),
			()-> assertEquals("INITIAL",
					service.getContactList().get(2).getAddress()));
			service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
	
		assertAll("service",
			()-> assertNotNull(service.getContactList().get(3).getContactID()),
			()-> assertEquals(firstNameTest,
					service.getContactList().get(3).getFirstName()),
			()-> assertEquals(lastNameTest,
					service.getContactList().get(3).getLastName()),
			()-> assertEquals(phoneNumberTest,
					service.getContactList().get(3).getPhoneNumber()),
			()-> assertEquals("INITIAL",
					service.getContactList().get(3).getAddress()));
			service.newContact(firstNameTest, lastNameTest, phoneNumberTest,addressTest);
	
		assertAll("service",
			()-> assertNotNull(service.getContactList().get(4).getContactID()),
			()-> assertEquals(firstNameTest,
					service.getContactList().get(4).getFirstName()),
			()-> assertEquals(lastNameTest,
					service.getContactList().get(4).getLastName()),
			()-> assertEquals(phoneNumberTest,
					service.getContactList().get(4).getPhoneNumber()),
			()-> assertEquals(addressTest,
			service.getContactList().get(4).getAddress()));
	}
			
@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, () -> service.deleteContact(contactID));
		assertAll(()-> service.deleteContact( service.getContactList().get(0).getContactID()));
			}

	void updateFirstNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();

		service.updateFirstName(service.getContactList().get(0).getContactID(),
				firstNameTest);
		assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class,
		()-> service.updateFirstName(service.getContactList().get(0).getContactID(),LongFirstName));

		assertThrows(IllegalArgumentException.class,
		()-> service.updateFirstName(service.getContactList().get(0).getContactID(), null));

		assertThrows(Exception.class,
		() -> service.updateFirstName(contactID, firstNameTest));
}


	@Test
	void updateLastNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateLastName(service.getContactList().get(0).getContactID(),lastNameTest);

		assertEquals(lastNameTest, service.getContactList().get(0).getLastName());

		assertThrows(IllegalArgumentException.class,
		()-> service.updateLastName(service.getContactList().get(0).getContactID(),LongLastName));

		assertThrows(IllegalArgumentException.class,
		()-> service.updateLastName(service.getContactList().get(0).getContactID(), null));

		assertThrows(Exception.class,
		() -> service.updateLastName(contactID, lastNameTest));
}

	@Test
	void updatePhoneNumberTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updatePhoneNumber(service.getContactList().get(0).getContactID(),phoneNumberTest);

		assertEquals(phoneNumberTest,service.getContactList().get(0).getPhoneNumber());

		assertThrows(IllegalArgumentException.class,
		()-> service.updatePhoneNumber(service.getContactList().get(0).getContactID(),LongPhoneNumber));

		assertThrows(IllegalArgumentException.class,
		()-> service.updatePhoneNumber(service.getContactList().get(0).getContactID(),ShortPhoneNumber));

		assertThrows(IllegalArgumentException.class,
		()-> service.updatePhoneNumber(service.getContactList().get(0).getContactID(), contactID));

		assertThrows(IllegalArgumentException.class,
		()-> service.updatePhoneNumber(service.getContactList().get(0).getContactID(), null));

		assertThrows(Exception.class,
		() -> service.updatePhoneNumber(contactID, lastNameTest));
}
	
	@Test
	void updateAddressTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateAddress(service.getContactList().get(0).getContactID(),addressTest);

		assertEquals(addressTest, service.getContactList().get(0).getAddress());

		assertThrows(IllegalArgumentException.class,
		()-> service.updateAddress(service.getContactList().get(0).getContactID(),LongAddress));

		assertThrows(IllegalArgumentException.class,
		()-> service.updateAddress(service.getContactList().get(0).getContactID(), null));

		assertThrows(Exception.class,
		() -> service.updateAddress(contactID, addressTest));
}

}