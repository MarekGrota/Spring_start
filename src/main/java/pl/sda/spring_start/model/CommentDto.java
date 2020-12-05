package pl.sda.spring_start.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    @NotBlank(message = "Comment must be not empty")
    @Size(min = 10, max = 5000, message = "Commnent must longer then {min}")
    private String message;
}
