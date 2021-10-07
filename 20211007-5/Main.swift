class Solution {
    func numIdenticalPairs(_ nums: [Int]) -> Int {
        var sortNums = nums.sorted()
        var ans = 0
        for i in 0 ..< sortNums.count-1 {
            for j in i+1 ..< sortNums.count {
                if(sortNums[i] == sortNums[j]) {
                    ans += 1
                }else {
                    break
                }
            }
        }
        return ans
    }
}