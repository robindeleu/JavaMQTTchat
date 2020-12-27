package be.vives.robin.chat;

class ChatMessage {
    public ChatMessage(String text, String user) {
        this.text = text;
        this.user = user;
      }
    
      public String getText() {
        return text;
      }
    
      public String getUser() {
        return user;
      }
    
      @Override
      public String toString() {
        return "[" + user + "]: " + text;
      }
    
      private String text = "";
      private String user = "";
      private String type = "chat_message";
    }