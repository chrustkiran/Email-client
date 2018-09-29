import java.io.Serializable;

public class Mail implements Serializable {
  String receiverAddress;
  String subject;
  String body;

 public String getReceiverAddress() {
  return receiverAddress;
 }

 public void setReceiverAddress(String receiverAddress) {
  this.receiverAddress = receiverAddress;
 }

 public String getSubject() {
  return subject;
 }

 public void setSubject(String subject) {
  this.subject = subject;
 }

 public String getBody() {
  return body;
 }

 public void setBody(String body) {
  this.body = body;
 }
}


