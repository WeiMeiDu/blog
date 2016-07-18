/**
 * 自定义的配置文件，将覆盖fckconfig.js
 * 
 */
// 自定义工具栏
// 数组：分割的作用，不同功能不同分组
// -：作用，也是分割，但是分隔符不同用在组内容
// /：用来分栏
FCKConfig.ToolbarSets["myToolbar"] = [
		[ 'Source', '-', 'Preview', '-', 'Templates' ],
		[ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteWord' ],
		[ 'Undo', 'Redo', '-', 'Find', 'Replace', '-', 'SelectAll',
				'RemoveFormat' ],
		'/',
		[ 'Bold', 'Italic', 'Underline', 'StrikeThrough', '-', 'Subscript',
				'Superscript' ],
		[ 'OrderedList', 'UnorderedList', '-', 'Outdent', 'Indent',
				'Blockquote', 'CreateDiv' ],
		[ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyFull' ],
		[ 'Link', 'Unlink', 'Anchor' ],
		[ 'Image', 'Flash', 'Table', 'Rule', 'Smiley', 'SpecialChar',
				'PageBreak' ], '/',
		[ 'Style', 'FontFormat', 'FontName', 'FontSize' ],
		[ 'TextColor', 'BGColor' ], [ 'FitWindow', 'ShowBlocks' ] // No comma
																	// for the
																	// last row.
];

// 这些是默认字体 'Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana' ;
// 自定义一些字体 宋体，黑体，楷体，方正舒体，方正姚体，仿宋，华文行楷
// 设置FCKeditor乱码时，将该文件编码改成utf-8
FCKConfig.FontNames = '宋体;黑体;楷体;方正舒体;方正姚体;仿宋;华文行楷';

// 自定义表情图片
// 原来图片位置/blog/WebRoot/user/fckeditor/editor/images/smiley/msn
// 配置表情图片存放位置
//修改图片列表
FCKConfig.SmileyPath = FCKConfig.BasePath + 'images/smiley/qq/';
FCKConfig.SmileyImages = [ '001.gif', '002.gif',
		'003.gif', '004.gif', '005.gif',
		'006.gif', '007.gif', '008.gif',
		'009.jpg', '010.jpg', '011.gif',
		'012.gif', '013.gif', '014.gif',
		'015.gif', '016.gif', '017.jpg' ];
//设定显示列数
FCKConfig.SmileyColumns = 4 ;
//设置图片显示宽和高
FCKConfig.SmileyWindowWidth		= 220 ;
FCKConfig.SmileyWindowHeight	= 110 ;


