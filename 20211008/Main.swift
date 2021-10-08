class Solution {
    func decompressRLElist(_ nums: [Int]) -> [Int] {
        var ans: [Int] = Array()
        for idx in stride(from: 0, to: nums.count, by: 2) {
            for _ in 1...nums[idx] {
                ans.append(nums[idx+1])
            }
        }
        return ans
    }
}