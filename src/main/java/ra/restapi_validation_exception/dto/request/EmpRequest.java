package ra.restapi_validation_exception.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpRequest {
    private long id;
    //Phải có thuộc tính name và name != null
    @NotNull(message = "Tên nhân viên không được null")
    private String name;
    private Date birthDate;
    @Pattern(regexp = "^(.+)@(.+)$",message = "Không đúng định dạng email")
    private String email;
    private String phone;
    private String address;
    private boolean status;
}
