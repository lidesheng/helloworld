CREATE TABLE `survey` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `enabled` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `question` (
  `id` int(11) NOT NULL auto_increment,
  `surveyId` int(11) default NULL,
  `performance` int(11) default NULL,
  `atmosphere` int(11) default NULL,
  `superStar` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;