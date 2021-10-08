class Solution {
    func getMinDistance(_ nums: [Int], _ target: Int, _ start: Int) -> Int {
        var ans = Int.max
        for idx in stride(from: 0, to: nums.count, by: 1) {
            if nums[idx] == target {
                ans = min(ans, abs(idx - start))
            }
        }
        return ans
    }
}