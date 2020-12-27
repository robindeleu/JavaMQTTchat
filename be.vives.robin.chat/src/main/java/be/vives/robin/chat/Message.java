package be.vives.robin.chat;

class Message {

    public Message(String type) {
      this.type = type;
    }
  
    public String getType() {
      return type;
    }
  
    @Override
    public String toString() {
      return "type = " + type;
    }
  
    private String type = "none";
  }