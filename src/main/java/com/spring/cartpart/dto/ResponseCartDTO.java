package com.spring.cartpart.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ResponseCartDTO
{
    private String message;
    private Object object;

    public ResponseCartDTO(String message,Object object)
    {
        this.message=message;
        this.object=object;
    }
}
