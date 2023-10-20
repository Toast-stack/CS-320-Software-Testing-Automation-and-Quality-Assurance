package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ContactTest {
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
	void contactTest() {
		Contact contact = new Contact();
		assertAll("constructor",
			()-> assertNotNull(contact.getContactID()),
			()-> assertNotNull(contact.getFirstName()),
			()-> assertNotNull(contact.getLastName()),
			()-> assertNotNull(contact.getPhoneNumber()),
			()-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdConstructorTest() {
		Contact contact = new Contact(contactID);
		assertAll("constructor one",
			()-> assertEquals(contactID, contact.getContactID()),
			()-> assertNotNull(contact.getFirstName()),
			()-> assertNotNull(contact.getLastName()),
			()-> assertNotNull(contact.getPhoneNumber()),
			()-> assertNotNull(contact.getAddress()));
	}
	@Test
	void contactIdAndFirstNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest);
		assertAll("constructor two",
			()-> assertEquals(contactID, contact.getContactID()),
			()-> assertEquals(firstNameTest, contact.getFirstName()),
			()-> assertNotNull(contact.getLastName()),
			()-> assertNotNull(contact.getPhoneNumber()),
			()-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdAndFullNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest);
		assertAll("constructor three",
			()-> assertEquals(contactID, contact.getContactID()),
			()-> assertEquals(firstNameTest, contact.getFirstName()),
			()-> assertEquals(lastNameTest, contact.getLastName()),
			()-> assertNotNull(contact.getPhoneNumber()),
			()-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdFullNamePhoneNumberConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest, phoneNumberTest);
		assertAll("constructor four",
			()-> assertEquals(contactID, contact.getContactID()),
			()-> assertEquals(firstNameTest, contact.getFirstName()),
			()-> assertEquals(lastNameTest, contact.getLastName()),
			()-> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
			()-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void allTheProperThingsConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest,phoneNumberTest, addressTest);
		assertAll("constructor all",
			()-> assertEquals(contactID, contact.getContactID()),
			()-> assertEquals(firstNameTest, contact.getFirstName()),
			()-> assertEquals(lastNameTest, contact.getLastName()),
			()-> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
			()-> assertEquals(addressTest, contact.getAddress()));
	}
	
	@Test
	void updateFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstNameTest);
		assertAll("first name",
			()-> assertEquals(firstNameTest, contact.getFirstName()),
			()-> assertThrows(IllegalArgumentException.class,()-> contact.setFirstName(null)),
			()-> assertThrows(IllegalArgumentException.class,()-> contact.setFirstName(LongFirstName)));
	}
	
	@Test
	void updateLastNameTest() {
		Contact contact = new Contact();
		contact.setLastName(lastNameTest);
		assertAll("last name",
			()-> assertEquals(lastNameTest, contact.getLastName()),
			()-> assertThrows(IllegalArgumentException.class,()-> contact.setLastName(null)),
			()-> assertThrows(IllegalArgumentException.class,()-> contact.setLastName(LongFirstName)));
	}
	
	@Test
	void updatePhoneNumberTest() {
		Contact contact = new Contact();
		contact.setPhoneNumber(phoneNumberTest);
		assertAll("phone number",
			()-> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
			()-> assertThrows(IllegalArgumentException.class,
			()-> contact.setPhoneNumber(null)),
			()-> assertThrows(IllegalArgumentException.class,
			()-> contact.setPhoneNumber(LongPhoneNumber)),
			()-> assertThrows(IllegalArgumentException.class,
			()-> contact.setPhoneNumber(ShortPhoneNumber)),
			()-> assertThrows(IllegalArgumentException.class,()-> contact.setPhoneNumber(contactID)));
	}
	
	@Test
	void updateAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(addressTest);
		assertAll("phone number",
			()-> assertEquals(addressTest, contact.getAddress()),
			()-> assertThrows(IllegalArgumentException.class,
			()-> contact.setAddress(null)),
			()-> assertThrows(IllegalArgumentException.class,
			()-> contact.setAddress(LongAddress)));
	}
	
	@Test
	void updateContactIdTest() {
		Contact contact = new Contact();
		contact.setContactId(contactID);
		assertAll("contact ID",
			()-> assertEquals(contactID, contact.getContactID()),
			()-> assertThrows(IllegalArgumentException.class,
			()-> contact.setContactId(null)),
			()-> assertThrows(IllegalArgumentException.class,
			()-> contact.setContactId(LongContactID)));
	}
}
