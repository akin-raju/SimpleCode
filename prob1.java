package strings.com;

/* Minimum number of times A has to be repeated such that B is a substring of it
 * Given two strings A and B. 
 * The task is to find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution exsits print -1.
 */
public class prob1 {
	private static int minimumRepeated(String A, String B) {
		int repetition=0;
		int ax=A.indexOf(B.charAt(0));
		int poss=ax;
		int length=A.length();
		if(ax!=-1) {
			for(int i=0;i<B.length();i++) {
				if(B.charAt(i)!=A.charAt(poss)) {
					ax=A.indexOf(B.charAt(0),ax+1);
					if(ax!=-1) {
						i=-1;
						poss=ax;
					}else {
						repetition=-1;
						break;
					}
				}else {
					poss++;
					if(poss>length-1) {
						repetition++;
						poss=0;
					}	
				}
			}
			if(poss<length &&poss!=0  &&repetition!=-1) {
				repetition++;
			}
		}else {
			repetition=-1;
		}
		return repetition;
	}
	 
	public static void main(String[] args) {
		String A="abcdxcde";
		String B="cde";
		System.out.println(minimumRepeated(A,B));
	}
}
