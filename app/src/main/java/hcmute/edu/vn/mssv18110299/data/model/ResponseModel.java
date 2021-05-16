package hcmute.edu.vn.mssv18110299.data.model;

public class ResponseModel {
    public boolean isSuccess;
    public String message;

    public ResponseModel() {
    }

    public ResponseModel(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
