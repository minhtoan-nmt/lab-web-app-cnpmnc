package vn.edu.hcmut.cse.adsoftweng.lab.error;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
    public static final String STUDENT_ID_EXISTED = "Học sinh với id này đã tồn tại";
    public static final String NOT_FILLED = "Các trường không được bỏ trống";
    public static final String INVALID_AGE = "Tuổi không hợp lệ! Phải dưới 30 tuổi mới được phép nhập học";
    public static final String NO_ERROR = "Ok";
}
