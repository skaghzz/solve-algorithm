class Solution {
    func allCellsDistOrder(_ rows: Int, _ cols: Int, _ rCenter: Int, _ cCenter: Int) -> [[Int]] {
        var ans: [[Int]] = []
        for r in 0..<rows {
            for c in 0..<cols {
                ans.append([r, c])
            }
        }
        var sorting = {
            (p1: [Int], p2: [Int]) -> Bool in
            return abs(p1[0] - rCenter) + abs(p1[1] - cCenter) < abs(p2[0] - rCenter) + abs(p2[1] - cCenter)
        }
        ans.sort(by: sorting)
        return ans
    }
}
