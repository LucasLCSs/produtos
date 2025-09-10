package joaolucas.produtos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ProdutoNaoEncontrado.class)
    public ResponseEntity<Map<String, Object>> ProdutoNaoEncontradoHandle(ProdutoNaoEncontrado e) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDate.now());
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("error", "Bad request");
        body.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(UsuarioNaoEncontrado.class)
    public ResponseEntity<Map<String, Object>> UsuarioNaoEncontradoHandle(UsuarioNaoEncontrado e) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDate.now());
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("error", "Bad request");
        body.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> ErrosNaoTratadosHandle(Exception e) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDate.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        body.put("error", "Error interno do servidor, contacte o administrador.");
        body.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
