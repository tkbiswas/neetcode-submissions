class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart =0, rowEnd = matrix.length -1;
        int rowIndex = 0;
        while(rowStart <= rowEnd){
            var mid = (rowStart + rowEnd) / 2;
            if(target == matrix[mid][0]) return true;
            if(target > matrix[mid][0] && target <= matrix[mid][matrix[0].length -1])
                rowIndex = mid;
            if(target < matrix[mid][0])
                rowEnd = mid-1;
            else
                rowStart = mid+1;    
        }
      
        int colStart =0, colEnd = matrix[0].length -1;
        while(colStart <= colEnd){
            var mid = (colStart + colEnd) / 2;
            if(target == matrix[rowIndex][mid]) return true;
            if(target < matrix[rowIndex][mid])
                colEnd = mid -1;
            else
                colStart = mid+1;    
        }
        return false;
    }
}
