let answerElements = [];
const questionElement = document.querySelector(".expression");
const scoreElement = document.querySelector(".currentScore");
const problemElement = document.querySelector(".currentProblem");
const restartButton = document.getElementById("btnStartOver");
const OPERATION = ' * ';
let problemArgs = [0,0];
let correctAnswer = -1;
let score = 0;
let problem = 0;
const numProblems = 10;
function init()
{
    answerElements = document.querySelectorAll("li");
    answerElements.forEach((_, i) => {
        answerElements[i].addEventListener('click', event =>
        {
            score += event.target.textContent == correctAnswer?(100/numProblems):0;
            reload();
        });
    })
    restartButton.addEventListener('click', event =>
    {
        score = 0;
        problem = 0;
        let showHideArr = document.querySelectorAll(".show-hide");
        showHideArr.forEach((_, i) => showHideArr[i].classList.remove("hidden"));
        reload();
    });
}
function reload()
{
    if(problem >= numProblems)
    {
        document.querySelectorAll(".show-hide").forEach((_, i, arr) => arr[i].classList.add("hidden"));
    }
    else
    {
        problemArgs.forEach((_, i) => problemArgs[i] =  randomRange(0,10));
        answerElements.forEach((_, i) => answerElements[i].textContent = randomRange(0,100, correctAnswer  = eval(questionElement.textContent = problemArgs[0] + OPERATION + problemArgs[1])));
        answerElements[randomRange(0,4)].textContent = correctAnswer;
        problemElement.textContent = ++problem;
    }
    scoreElement.textContent = score;
}
function randomRange(min, max, exclude = -1)
{
    let ret = Math.floor(Math.random() * (max-min)) + min;
    return ret==exclude?randomRange(min,max,exclude):ret;
}
init();
reload();