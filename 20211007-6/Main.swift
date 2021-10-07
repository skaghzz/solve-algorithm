class Solution {
    func smallerNumbersThanCurrent(_ nums: [Int]) -> [Int] {
        var ans: [Int] = Array(repeating: 0, count: nums.count)
        for i in 0 ..< nums.count {
            var maxCount = 0
            for j in 0 ..< nums.count {
                if (nums[i] > nums[j]) {
                    maxCount += 1
                }
            }
            ans[i] = maxCount
        }
        return ans
    }
}