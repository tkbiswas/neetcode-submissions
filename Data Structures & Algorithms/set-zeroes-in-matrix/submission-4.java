class Solution {
    public void setZeroes(int[][] matrix) {
        var visited = new HashSet<String>();
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0 && !visited.contains(""+i+","+j)){
                     for(int k=0; k< matrix[0].length; k++){
                         if( matrix[i][k] != 0){
                            matrix[i][k] = 0;
                            visited.add((""+i+","+k));
                         }
                       
                     }
                     for(int m=0; m< matrix.length; m++){
                         if( matrix[m][j] != 0){

                        matrix[m][j] = 0;
                         visited.add((""+m+","+j));
                         }
                     }
                }
        }
        }
        
    }
}
