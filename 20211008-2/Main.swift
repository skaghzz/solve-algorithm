class Solution {
    func projectionArea(_ grid: [[Int]]) -> Int {
        var ans = 0
        var xzMax = Array(repeating: 0, count: grid.count)
        var yzMax = Array(repeating: 0, count: grid.count)
        
        // x-y
        for x in grid {
            for v in x {
                if (v > 0) {
                    ans += 1
                }
            }
        }
        
        // x-z
        for idx in stride(from: 0, to: grid.count, by: 1) {
            ans += grid[idx].max()!
        }
        
        // y-z
        for idx in stride(from: 0, to: grid.count, by: 1) {
            ans += grid.map({
                $0[idx]
            }).max()!
        }
        return ans
    }
}