package table.bind;

/**
 * request parameter 를 받을 클래스로부터 정보 획득
 * 0번부터 짝수 : name
 * 1번부터 홀수 : value
 *
 */
public interface DataBinding {
	Object[] getDataBinders();
}
