class Solution {
    func removeElement(_ nums: inout [Int], _ val: Int) -> Int {
        for idx in stride(from: 0, to: nums.count, by: 1) {
            if (nums[idx] == val) {
                nums[idx] = -1
            }
        }
        nums.removeAll(where: {
            $0 == -1
        })
        return nums.count
    }
}