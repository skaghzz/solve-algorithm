class Solution {
    func shuffle(_ nums: [Int], _ n: Int) -> [Int] {
        var ans: [Int] = Array(repeating: 0, count: nums.count)
        var ansIdx = 0
        for idx in 0..<n {
            ans[ansIdx] = nums[idx]
            ans[ansIdx+1] = nums[n+idx]
            ansIdx += 2
        }
        return ans
    }
}