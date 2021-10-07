class Solution {
    func restoreString(_ s: String, _ indices: [Int]) -> String {
        var c: [Character] = Array(s)
        var ans: [Character] = Array(repeating: " ", count: s.count)
        
        for (index, value) in indices.enumerated() {
            ans[value] = c[index]
        }
        return String(ans)
    }
}