class Solution {
    func runningSum(_ nums: [Int]) -> [Int] {
        var sum = 0
        return nums.map({(value) -> Int in
            sum += value
            return sum
        })
    }
}