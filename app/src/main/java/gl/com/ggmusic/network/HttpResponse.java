package gl.com.ggmusic.network;

class HttpResponse{
        private int responseCode;
        private String responseMessage;
        private String responseContent ;

        public int getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(int responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        public String getResponseContent() {
            return responseContent;
        }

        public void setResponseContent(String responseContent) {
            this.responseContent = responseContent;
        }
    }
    