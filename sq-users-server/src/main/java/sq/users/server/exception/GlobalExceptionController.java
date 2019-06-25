package sq.users.server.exception;


import cn.sq.users.core.exception.MyErrorEnum;
import cn.sq.users.core.exception.MyException;
import cn.sq.users.core.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * 系统例外处理
 *
 */
@ControllerAdvice
public class GlobalExceptionController {
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

	private final int runTimeError = 400;
	
	private final int validateError = 300;

	private final int sqlError = 280;

	@ExceptionHandler(MyException.class)
	public ResponseEntity<Result> handleCustomException(MyException ex) {
		String errmsg = null;
		if (ex.getMyErrorEnum().equals(MyErrorEnum.errorParm)) {
			errmsg = ex.getLocalizedMessage();
		} else {
			errmsg = ex.getMyErrorEnum().getErrorMsg();
			if(StringUtils.isEmpty(errmsg)) {
				errmsg = ex.getMessage();
			}
		}
		GlobalExceptionController.logger.error("哎呦！异常::" + ex.getLocalizedMessage(), ex);
		return new ResponseEntity<Result>(Result.failure(ex.getMyErrorEnum().getErrorCode(),errmsg), HttpStatus.OK);
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<Result> handleValidatException(BindException ex, BindingResult results) {
	    ex.printStackTrace();
	    StringBuffer sb =new  StringBuffer();
	    if(results.hasErrors()) {
	        List<FieldError> errors =results.getFieldErrors();
	        errors.stream().forEach(x -> sb.append(x.getField()+"=["+x.getDefaultMessage()).append("];") );
	    }
	    return new ResponseEntity<Result>(Result.failure(validateError, sb.toString()), HttpStatus.OK);
	 }

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Result> handleRuntimeException(RuntimeException e) {
		GlobalExceptionController.logger.error(e.getMessage(), e);
		return new ResponseEntity<Result>(Result.failure(runTimeError,e.getMessage()), HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllException(Exception ex) {
		ex.printStackTrace();
		return new ResponseEntity<String>(ex.getLocalizedMessage(), HttpStatus.OK);
	}

}