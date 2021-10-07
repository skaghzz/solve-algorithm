class Solution {
    func decode(_ encoded: [Int], _ first: Int) -> [Int] {
        var ans: [Int] = Array(repeating: 0, count: encoded.count+1)
        ans[0] = first
        for idx in stride(from: 0, to: encoded.count, by: 1) {
            ans[idx+1] = encoded[idx] ^ ans[idx]
        }
        return ans
    }
}