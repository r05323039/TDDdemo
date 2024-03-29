package tdd;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UndoRedoException extends RuntimeException {
    private String message;
}
