package common;

public class CommonLoggerImpl implements CommonLogger{

	@Override
	public void log(String message) {
		System.out.println("CommonLogger - "+message);
	}
	
	
}
