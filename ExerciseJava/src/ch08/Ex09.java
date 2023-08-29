package ch08;

class UnsupportedFuctionException extends RuntimeException {
	final private int ERR_CODE;

	UnsupportedFuctionException(String msg, int errCode) { // 생성자
		super(msg); 
		ERR_CODE = errCode; 
		} 

	UnsupportedFuctionException(String msg) {
		this(msg, 100);
	}

	public int getErrCode() {
		return ERR_CODE;
	}

	public String getMessage() {
		return "[" + getErrCode() + "]" + super.getMessage();
	}
}

class Ex09 {
	public static void main(String[] args){
		try {
			throw new UnsupportedFuctionException("지원하지 않는 기능입니다.", 100);
		} catch (UnsupportedFuctionException e) {
			System.out.println(e.getMessage());
		}
	}
}