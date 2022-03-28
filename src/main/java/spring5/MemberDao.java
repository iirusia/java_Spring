package spring5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private static long nextId = 0;

	private Map<String, Member> map = new HashMap<>();
	/*
	 * HashMap<key,value>	-HashMap은 Map의 일종으로 key와 value의 쌍으로 이루어진 데이터를 보관
		HashMap 특징
		-null key와 null value를 모두 허용
		-내부적으로 데이터에 접근할 때 동기화를 보장하지 않는다.
		-데이터에 순서를 보장하지 않는다.
		-중복된 key값은 가질 수 없음 하지만 죽복된 value는 가질 수 있다
		사용되는 메서드 
		-put() 데이터 넣기(한개만)
		-putAll() 인자로 전달된 Map에 대한 대한 데이터 모드 저장
		-get() 	인자로 전달된 key에 해당하는 value를 리턴해준다 key가 존재하지 않으면 null
				여기서는 get(email) 을 넣으면 value로 지정한 Member를 리턴한다.
		-remove() 인자로 전달된 key에 해당하는 데이터를 삭제한다.
					삭제가 되면 value값 리턴되고 없는 값이라면 null 리턴
					삭제가 되었는지도 확인하기 위해 값 확인할 수 있음
		-clear()	HashMap의 모든 데이터를 삭제함
		-isEmpty()	HashMap의 데이터가 비었다면 true를 리턴하고 아니면 false를 리턴한다.
		-KeySet() 	HashMap에 저장된 key들을 Set객체로 리턴한다.
		-valuese()	HashMap에 저장된 value들을 Collection 객체로 리턴
		-containsKey()	HashMap에 인자로 전달된 key가 존재하면 true를 리턴하고 그렇지 않으면
						false를 리턴한다.
		-containsValue()	HashMap에 인자로 전달된 key가 존재하면 true를 리턴하고 그렇지 않으면
							false를 리턴한다. 
		-replace() 	인자로 전달된 key의 value를 인자로 전달된 value로 교체해준다. 교체되어 삭제되는 value는 리턴된다.
					존재하지 않는 key가 인자로 전달되면 null이 리턴
							
	 * key = String , value = Member 타입 지정
	 * 
	 * put(email,Member) 이 방식으로 데이터를 넣는다.
	 * 
	 * 
	 * 
	 * 
	 * */

	public Member selectByEmail(String email) {
		return map.get(email);
	}

	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}

	public void update(Member member) {
		map.put(member.getEmail(), member);
	}

	public Collection<Member> selectAll() {
		return map.values();
	}
}
