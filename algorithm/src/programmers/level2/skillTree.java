package programmers.level2;

//스킬트리
public class skillTree {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            int[] idxs = new int[skill.length()];
            String str = skill_trees[i];
            for (int j = 0; j < skill.length(); j++) {
                char c = skill.charAt(j);
                idxs[j] = str.indexOf(c);
            }
            boolean flag = true;
            for (int t = 0; t < idxs.length - 1; t++) {
                if (idxs[t] == -1 && idxs[t+1] != -1) {
                    flag = false;
                }
                if (idxs[t] > idxs[t+1] && idxs[t+1] != -1) {
                    flag = false;
                }
            }
            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}
