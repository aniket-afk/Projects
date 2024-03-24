/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aniketpatole
 */
public class LabRequest {
    private String test_name;
        private String sender;
        private String receiver;
        private String status;

        public LabRequest(String test_name, String sender, String receiver, String status) {
            this.test_name = test_name;
            this.sender = sender;
            this.receiver = receiver;
            this.status = status;
        }

        public String getMessage() {
            return test_name;
        }

        public String getSender() {
            return sender;
        }

        public String getReceiver() {
            return receiver;
        }

        public String getStatus() {
            return status;
        }
}
