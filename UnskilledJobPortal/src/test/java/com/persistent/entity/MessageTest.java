package com.persistent.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageTest {
	
	//Massage.setContent()
		//category.getContent()
		@Test
		public void MassageContentTest() {
			Message msg=new Message();
			String msgName="message1";
			
			msg.setContent("message1");
			String result=msg.getContent();
			
			
			assertEquals(msgName, result);
			
		}
		
		//Massage.setType()
		//Message.getType()
		@Test
		public void MassageTypeTest() {
			Message msg=new Message();
			String msgType="secret";
			
			msg.setType(msgType);
			String result=msg.getType();
			
			assertEquals(msgType, result);
			
		}

		//Test constructor Massage(String content,String type)
		@Test
		public void TestMassageConstructorParametrisedWithParametersContentAndType() {
			Message msg=new Message("message1","secret");
			assertEquals("message1", msg.getContent());
			assertEquals("secret", msg.getType());
		
		}
		
		//Test the toString method for empty object
		@Test
		public void TestMassageToStringEmptyObject() {
			Message msg=new Message();
			
			String result = "Message [content=" + null + ", type=" + null + "]";
			
			assertEquals(msg.toString(),result);
			
		}
		
		//Test the toString method for  object with data
		@Test
		public void TestMassageToStringWithObject() {
			Message msg=new Message("message1","secret");
			
			
//			Case : we can use StringBuilder for this
//			StringBuilder sb=new StringBuilder();
//			sb.append("Massage [content=");
//			sb.append(1);
//			sb.append(", type=");
//			sb.append("Maid");
//			sb.append("]");
//			
//			assertEquals(category.toString(),new String(sb));
			
		//	Case 2: Use string and add with + sign manually
			String res="Message [content="
					+"message1"
					+", type="
					+"secret"
					+"]";
			
			
			assertEquals(msg.toString(),res);

			
		}

}
