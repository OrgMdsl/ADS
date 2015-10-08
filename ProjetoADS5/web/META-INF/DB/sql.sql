USE [ProjetoADS5]
GO
/****** Object:  Schema [Pessoa]    Script Date: 10/08/2015 20:53:30 ******/
CREATE SCHEMA [Pessoa] AUTHORIZATION [dbo]
GO
/****** Object:  Schema [Core]    Script Date: 10/08/2015 20:53:31 ******/
CREATE SCHEMA [Core] AUTHORIZATION [dbo]
GO
/****** Object:  Schema [Chamado]    Script Date: 10/08/2015 20:53:31 ******/
CREATE SCHEMA [Chamado] AUTHORIZATION [dbo]
GO
/****** Object:  Table [Chamado].[Nivel]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Chamado].[Nivel](
	[id_nivel] [int] NOT NULL,
 CONSTRAINT [PK_Nivel] PRIMARY KEY CLUSTERED 
(
	[id_nivel] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Pessoa].[TipoPerfil]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Pessoa].[TipoPerfil](
	[id_tipo_perfil] [int] NOT NULL,
 CONSTRAINT [PK_TipoPerfil] PRIMARY KEY CLUSTERED 
(
	[id_tipo_perfil] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Chamado].[TipoChamado]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Chamado].[TipoChamado](
	[id_tipo_chamado] [int] NOT NULL,
 CONSTRAINT [PK_TipoChamado] PRIMARY KEY CLUSTERED 
(
	[id_tipo_chamado] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Chamado].[Status]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Chamado].[Status](
	[id_status] [int] NOT NULL,
 CONSTRAINT [PK_Status] PRIMARY KEY CLUSTERED 
(
	[id_status] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Core].[Sistema]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Core].[Sistema](
	[id_sistema] [int] NOT NULL,
 CONSTRAINT [PK_Sistema] PRIMARY KEY CLUSTERED 
(
	[id_sistema] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Pessoa].[Setor]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Pessoa].[Setor](
	[id_setor] [int] NOT NULL,
 CONSTRAINT [PK_Setor] PRIMARY KEY CLUSTERED 
(
	[id_setor] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Chamado].[Prioridade]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Chamado].[Prioridade](
	[id_prioridade] [int] NOT NULL,
 CONSTRAINT [PK_Prioridade] PRIMARY KEY CLUSTERED 
(
	[id_prioridade] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Pessoa].[Pessoa]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Pessoa].[Pessoa](
	[id_pessoa] [int] NOT NULL,
	[id_setor] [int] NULL,
 CONSTRAINT [PK_Pessoa] PRIMARY KEY CLUSTERED 
(
	[id_pessoa] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Pessoa].[Perfil]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Pessoa].[Perfil](
	[id_perfil] [int] NOT NULL,
	[id_tipo_perfil] [int] NULL,
	[id_pessoa] [int] NULL,
	[id_setor] [int] NULL,
 CONSTRAINT [PK_Perfil] PRIMARY KEY CLUSTERED 
(
	[id_perfil] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Chamado].[Chamado]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Chamado].[Chamado](
	[id_chamado] [int] NOT NULL,
	[id_tipo_chamado] [int] NULL,
	[id_prioridade] [int] NULL,
	[id_nivel] [int] NULL,
	[id_status] [int] NULL,
 CONSTRAINT [PK_Chamado] PRIMARY KEY CLUSTERED 
(
	[id_chamado] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Chamado].[Historico]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Chamado].[Historico](
	[id_historico] [int] NOT NULL,
	[id_chamado] [int] NULL,
 CONSTRAINT [PK_Historico] PRIMARY KEY CLUSTERED 
(
	[id_historico] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [Chamado].[HistoricoItem]    Script Date: 10/08/2015 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Chamado].[HistoricoItem](
	[id_historico_item] [int] NOT NULL,
	[id_historico] [int] NULL,
 CONSTRAINT [PK_HistoricoItem] PRIMARY KEY CLUSTERED 
(
	[id_historico_item] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_Perfil_Pessoa]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Pessoa].[Perfil]  WITH CHECK ADD  CONSTRAINT [FK_Perfil_Pessoa] FOREIGN KEY([id_pessoa])
REFERENCES [Pessoa].[Pessoa] ([id_pessoa])
GO
ALTER TABLE [Pessoa].[Perfil] CHECK CONSTRAINT [FK_Perfil_Pessoa]
GO
/****** Object:  ForeignKey [FK_Perfil_Setor]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Pessoa].[Perfil]  WITH CHECK ADD  CONSTRAINT [FK_Perfil_Setor] FOREIGN KEY([id_setor])
REFERENCES [Pessoa].[Setor] ([id_setor])
GO
ALTER TABLE [Pessoa].[Perfil] CHECK CONSTRAINT [FK_Perfil_Setor]
GO
/****** Object:  ForeignKey [FK_Perfil_TipoPerfil]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Pessoa].[Perfil]  WITH CHECK ADD  CONSTRAINT [FK_Perfil_TipoPerfil] FOREIGN KEY([id_tipo_perfil])
REFERENCES [Pessoa].[TipoPerfil] ([id_tipo_perfil])
GO
ALTER TABLE [Pessoa].[Perfil] CHECK CONSTRAINT [FK_Perfil_TipoPerfil]
GO
/****** Object:  ForeignKey [FK_Chamado_Nivel]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Chamado].[Chamado]  WITH CHECK ADD  CONSTRAINT [FK_Chamado_Nivel] FOREIGN KEY([id_nivel])
REFERENCES [Chamado].[Nivel] ([id_nivel])
GO
ALTER TABLE [Chamado].[Chamado] CHECK CONSTRAINT [FK_Chamado_Nivel]
GO
/****** Object:  ForeignKey [FK_Chamado_Prioridade]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Chamado].[Chamado]  WITH CHECK ADD  CONSTRAINT [FK_Chamado_Prioridade] FOREIGN KEY([id_prioridade])
REFERENCES [Chamado].[Prioridade] ([id_prioridade])
GO
ALTER TABLE [Chamado].[Chamado] CHECK CONSTRAINT [FK_Chamado_Prioridade]
GO
/****** Object:  ForeignKey [FK_Chamado_Status]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Chamado].[Chamado]  WITH CHECK ADD  CONSTRAINT [FK_Chamado_Status] FOREIGN KEY([id_status])
REFERENCES [Chamado].[Status] ([id_status])
GO
ALTER TABLE [Chamado].[Chamado] CHECK CONSTRAINT [FK_Chamado_Status]
GO
/****** Object:  ForeignKey [FK_Chamado_TipoChamado]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Chamado].[Chamado]  WITH CHECK ADD  CONSTRAINT [FK_Chamado_TipoChamado] FOREIGN KEY([id_tipo_chamado])
REFERENCES [Chamado].[TipoChamado] ([id_tipo_chamado])
GO
ALTER TABLE [Chamado].[Chamado] CHECK CONSTRAINT [FK_Chamado_TipoChamado]
GO
/****** Object:  ForeignKey [FK_Historico_Chamado]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Chamado].[Historico]  WITH CHECK ADD  CONSTRAINT [FK_Historico_Chamado] FOREIGN KEY([id_chamado])
REFERENCES [Chamado].[Chamado] ([id_chamado])
GO
ALTER TABLE [Chamado].[Historico] CHECK CONSTRAINT [FK_Historico_Chamado]
GO
/****** Object:  ForeignKey [FK_HistoricoItem_Historico]    Script Date: 10/08/2015 20:53:32 ******/
ALTER TABLE [Chamado].[HistoricoItem]  WITH CHECK ADD  CONSTRAINT [FK_HistoricoItem_Historico] FOREIGN KEY([id_historico])
REFERENCES [Chamado].[Historico] ([id_historico])
GO
ALTER TABLE [Chamado].[HistoricoItem] CHECK CONSTRAINT [FK_HistoricoItem_Historico]
GO
