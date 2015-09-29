ICP book exercises

## Install Racket & use from vim
Notes for Ubuntu. TMUX must be installed
(Instructions base on http://crash.net.nz/posts/2014/08/configuring-vim-for-sicp/)

* Install racket
```bash
sudo apt-get install racket
```
* Download the _scmindent.rkt_
* Edit the _.vimrc_ file with the following line:
```bash
autocmd filetype lisp,scheme,art setlocal equalprg=PATH/TO/scmindent.rkt
```
* Add _highligthing_ support for parentheses in Vim. Install _rainbow_ using _pathogen_
```bash
cd ~/.vim/bundle
git clone git@github.com:luochen1990/rainbow.git
```
* Install _tslime_ to send _lisp_ commands to racket REPL
```bash
cd ~/.vim/bundle
git clone git@github.com:sjl/tslime.vim.git
```
## Using Racket, Vim, Tmux

* Open Tmux
```bash
tmux
```
* Open two panes. (Example pane 0 for Vim, pane 1 for REPL)
* Open vim in pane 0
* Open REPL in pane 1 `racket -i -p neil/sicp -l xrepl`
* Connect pane 0 with pane 1 
```bash
ctrl-x v
window: 0
session: 0
pane: 1
```
* In Vim pane, write the lisp expressions, select it in visual mode and hit ctrl-c ctrl-c to send it to REPL
