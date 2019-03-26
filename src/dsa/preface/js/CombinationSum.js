const getNums = (nums, target) => {
  nums.sort((a, b) => a - b); // nlogn
  const res = [];
  backtrack(res, nums, 0, target, 0, []);

  return res;
};


const backtrack = (res, nums, start, target, current, list) => {
  if (target < current) return;
  if (target === current) {
    res.push([...list]); // clone of list
    return;
  } else {
    for (let i = start; i < nums.length; i++) {

      list.push(nums[i]);

      backtrack(res, nums, i + 1, target, current + nums[i], list);

      list.pop();
    }
  }
};

const nums = [1, 2, 3];
const target = 3;
console.log(getNums(nums, target));