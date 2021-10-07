class Solution {
    func finalValueAfterOperations(_ operations: [String]) -> Int {
        var ans = 0
        for operation in operations {
            if (operation.contains("+")) {
                ans += 1
            }else {
                ans -= 1
            }
        }
        return ans
    }
}