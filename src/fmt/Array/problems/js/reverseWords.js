/**
 * @param {string} str
 * @returns {string}
 */
const reverseWords = str => str.trim().split(/ +/g).reverse().join(' ');
const reverseWordsIII = str => str.split(/ +/g).map(x => x.split('').reverse().join('')).join(' ');

const test = "Let's take LeetCode contest";

console.log(reverseWords(test));
console.log(reverseWordsIII(test));