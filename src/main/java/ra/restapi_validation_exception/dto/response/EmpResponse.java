package ra.restapi_validation_exception.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpResponse {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean status;
}
