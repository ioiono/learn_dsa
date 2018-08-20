/**
 * @param {number[]} nums
 * @return {string}
 */
const largestNumber = nums => nums.every(x => x === 0) ? '0' : nums.sort((a, b) => "" + a + b < "" + b + a).join('');

console.log(largestNumber([3, 30, 34, 5, 9]));
console.log(largestNumber([0, 0]));
console.log(largestNumber([1, 1]));