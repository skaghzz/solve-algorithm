class Solution {
    func findJudge(_ n: Int, _ trust: [[Int]]) -> Int {
        var isTrusting: [Bool] = Array(repeating: false, count: n+1)
        var trustCount: [Int] = Array(repeating: 0, count: n+1)
        for t in trust {
            isTrusting[t[0]] = true
            trustCount[t[1]] += 1
        }
        for idx in stride(from: 1, through: n, by: 1) {
            if (trustCount[idx] == n-1 && !isTrusting[idx]) {
                return idx
            }
        }
        return -1
    }
}