class Solution {
    func maximumWealth(_ accounts: [[Int]]) -> Int {
        var tempMax = Int.min
        for account in accounts {
            var sum = account.reduce(0, {
                $0+$1
            })
            tempMax = tempMax > sum ? tempMax : sum 
        }
        return tempMax
    }
}