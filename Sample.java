class Sample{
    /***************PROBLEM-1*******************/
    //TC:0(n*k)
    //SC:0(n)
    class Solution {
        TrieNode root;
        public String replaceWords(List<String> dictionary, String sentence) {
            if(sentence==null || sentence.length()==0 || dictionary.size()==0 || dictionary==null){
                return sentence;
            }

            root=new TrieNode();
            for(String word:dictionary){
                insert(word);
            }

            String[] split=sentence.split(" ");
            StringBuilder answer=new StringBuilder();
            for(int i=0;i<split.length;i++){
                if(i!=0){
                    answer.append(" ");
                }
                String word=split[i];
                TrieNode curr=root;
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<word.length();j++){
                    char each=word.charAt(j);
                    if(curr.children[each-'a']==null || curr.isEnd==true){
                        break;
                    }
                    sb.append(each);
                    curr=curr.children[each-'a'];
                }

                if(curr.isEnd==true){
                    answer.append(sb.toString());
                }else{
                    answer.append(word);
                }
            }
            return answer.toString();
        }

        private class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children=new TrieNode[26];
                isEnd=false;
            }
        }

        private void insert(String word){
            TrieNode curr=root;
            for(char each:word.toCharArray()){
                if(curr.children[each-'a']==null){
                    curr.children[each-'a']=new TrieNode();
                }
                curr=curr.children[each-'a'];
            }
            curr.isEnd=true;
        }
    }

    /***********************PROBLEM-2*******************/
}